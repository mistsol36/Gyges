package core

import com.typesafe.config.ConfigFactory
import core.ui.controller.IsAppWidgetController

import scala.collection.JavaConverters._

/**
  * 設定ファイル（application.conf）を元に、AppWidgetのコントローラのインスタンス生成します。
  * 各AppWidgetから本クラスにアクセスすることはないため、coreパッケージからのみ利用可能とします。
  *
  * Created by bububu10 on 2016/05/21.
  */
private[core] object AppWidgetCtrlFactory {

  /** AppWidgetsの設定リスト */
  private val appWidgetConfigs: List[AppWidgetConfig] = loadAppWidgetsConfig

  /**
    * application.confからAppWidgetsの設定を読み込み、
    * 設定情報を表すクラスのリストに変換する
    *
    * @return AppWidgetConfigのリスト
    */
  private def loadAppWidgetsConfig(): List[AppWidgetConfig] = {
    val conf = ConfigFactory.load
    val ids = conf.getObject("AppWidgets").keySet.asScala
    ids.map(id => {
      val obj = conf.getObject(s"AppWidgets.${id}")
      val name = obj.get("name").toString
      val fqcn = obj.get("fqcn").toString
      new AppWidgetConfig(id, name, fqcn)
    }).toList
  }

  /**
    * 与えられたidに対応するAppWidgetのコントローラのインスタンスを生成します。
    *
    * @param id
    * @return AppWidgetのコントローラのインスタンス
    */
  def create(id: String): IsAppWidgetController = {
    val opt = appWidgetConfigs.find(conf => conf.id.equals(id))
    if (opt.isEmpty) throw new IllegalArgumentException("id's not found")
    val c = Class.forName(opt.get.fqcn)
    c.newInstance().asInstanceOf[IsAppWidgetController]
  }

  /**
    * AppWidgetの設定情報を表すクラス
    *
    * @param id   AppWidgetのid
    * @param name AppWidgetの名前
    * @param fqcn AppWidgetのcontrollerのFQCN
    */
  private[core] case class AppWidgetConfig(id: String, name: String, fqcn: String)

}
