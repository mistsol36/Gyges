package core

import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuite

import scala.collection.JavaConverters._

/**
  * application.confにまつわるテスト
  *
  * scalatestのスタイルは色々あるので以下参照、FunSuiteが一番シンプルっぽい
  * http://www.scalatest.org/user_guide/selecting_a_style
  *
  * Created by bububu10 on 2016/05/22.
  */
class ApplicationConfTest extends FunSuite {
  val conf = ConfigFactory.load()
  val obj = conf.getObject("AppWidgets")

  val testName1 ="assertionを行なっていないので常に成功する。ConfigとConfigObjetctの使い方検証。"
  test(testName1) {
    println(s"============${testName1}===========")
    println(obj)
    // あまり関係ないけど、引数がなく副作用がないメソッドは()無しで呼び出すのがscalaのお作法らしい
    // ()があれば副作用がある、()がなければ副作用がない、というのが直感的にわかるから、とのこと
    println(obj.keySet)
    println(obj.keySet.getClass)
    println(obj.keySet.asScala) // scalaのコレクションが使いたいのでJavaConvertersで変換する

    // KeySetで取得したkeyで回してみる
    var cnt = 1
    obj.keySet.asScala.foreach(e => {
      println(s"-------------${cnt}回目-------------")
      println(obj.get(e)) // ここから先のnameとかにアクセスしたいがgetメソッドが無い。。。
      cnt += 1
    })
  }

  val testName2 = "assertionを行なっていないので常に成功する。ConfigとConfigObjetctの使い方検証その２。"
  test(testName2) {
    println(s"============${testName2}===========")
    val keys = conf.getObject("AppWidgets").keySet().asScala
    var cnt = 1
    keys.foreach(e => {
      println(s"-------------${cnt}回目-------------") // ここまではさっきと一緒
      // keyを付け足した文字列でConfigからConfigObjectを取得してみる
      println(conf.getObject(s"AppWidgets.${e}").get("name")) // できた
      cnt += 1
    })
  }
}
