
package twirl.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String = "Home"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<html>
<body>
Enter your gamer name: <input type="text" name="enterName"><br>
<input type="submit" value="Start Game">
<!--Grab input value-->
</body>
</html>"""))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 03 22:42:17 BST 2019
                  SOURCE: /home/will/workspace/RockPaperSciccorsPlusTwo/src/main/scala/twirl/home.scala.html
                  HASH: 77fe937a31902d478b366a24ed7f060adb26df6c
                  MATRIX: 565->1|683->26
                  LINES: 14->1|19->2
                  -- GENERATED --
              */
          