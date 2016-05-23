package core.ui.controller;

import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * GygesAppのMainFrameに組み込まれるAppWidgetのコントローラが実装すべきインタフェース
 * <p>
 * Created by bububu10 on 2016/05/21.
 */
public interface IsAppWidgetController {

    /**
     * 現時点では各AppWidgetは以下のサイズを使ってください
     */
    int DEFUALT_WIDTH = 200;
    int DEFUALT_HEIGHT = 200;

    /**
     * AppWidgetを更新します。
     * このメソッドには各ウィジェットの更新時に行う処理を実装してください。
     */
    void update();

    /**
     * トップレベルのView要素を返すよう実装してください。
     * MainFrame側でじゃ今のところは深く考えずNodeで受け取ることにします。
     * 問題があれば変更します。
     */
    Node getParent();
}
