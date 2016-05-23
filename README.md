# Gyges

webAPIから取得した情報をウィジェットとして表示することができるフレームを作ります。
ウィジェットはJavaFXで、コアとなるフレームやユーティリティはscalaで実装します。
JavaFXの概要については[Oracleの公式ドキュメント](https://docs.oracle.com/javase/jp/8/javafx/get-started-tutorial/jfx-overview.htm)等を参照してください。

## Status

現在はコアとなるフレーム、ユーティリティについて実装中です。
またサンプルとして以下のwebAPIの取得、表示について実装する予定です。
ユーティリティとして何が提供されると便利なのか、はサンプル実装を終えてから随時検討します。

* [SimpleAPI vol.3 - Wikipedia API](http://wikipedia.simpleapi.net/)
* [kizAPI(きざっぴ)](http://kizasi.jp/tool/kizapi.html)

## Architecture

作成中。。。詳細はwikiに記載予定です。

## Requirements for development
開発には以下のツールのインストールが必要です。

### [jdk1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
JavaFX、scalaの利用、IDEの利用に必要となります。8u40以前では一部動かないところがあるので、
それ以降のバージョンのものをインストールしてください。現時点（2016/5/22）の最新は8u92です。

### [JavaFX Scene Builder](http://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html)
JavaFXのfxmlをGUIで作成できます。現時点（2016/5/22）の最新は2.0です。

### gitクライアント
Windowsの場合は[msysgit](https://msysgit.github.io/)のインストールを推奨します。
Macの場合は[homebrew](http://brew.sh/index_ja.html)経由でのインストールを推奨します。

### sbt
Javaでいうところのmavenにあたります。
本プロジェクトでは主にライブラリの依存関係の解決のために利用しています。
[mvn repository](http://mvnrepository.com/)にあるライブラリであれば、
build.sbtファイルに記載するだけで、ライブラリDL + ビルドパスへの追加まで自動化できます。
mvn repositoryに無いライブラリもresolverを設定すれば指定可能です。

Windowsの場合は[sbt](http://www.scala-sbt.org/download.html)からインストーラをDL、インストールを推奨します。
Macの場合は[homebrew](http://brew.sh/index_ja.html)経由でのインストールを推奨します。

### IDE
以下の２つのIDEへのプロジェクトインポートは検証する予定です。（現時点ではeclipseは未検証）
好みのIDEをインストールしてください。
scalaの実装を行う場合はIntellij Ideaがおすすめです。

  * [Intellij Idea](https://www.jetbrains.com/idea/)
  * [Eclipse Mars](https://eclipse.org/mars/)

#### eclipseへのインポート
ScalaIDE(eclipse Luna)へのインポート前に、プロジェクト直下で以下のコマンドを実行する必要があります。

    $ sbt eclipse

このコマンドでeclipseの設定ファイルである.projectと.classpathが生成されます。
import -> General -> Existing Projects into Workspace からインポートしてください。
