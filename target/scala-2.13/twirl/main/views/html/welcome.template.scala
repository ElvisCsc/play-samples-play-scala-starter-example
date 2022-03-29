
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "scala"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<section id="top">
  <div class="wrapper">
    <h1><a href="https://playframework.com/documentation/"""),_display_(/*7.59*/version),format.raw/*7.66*/("""/Home">"""),_display_(/*7.74*/message),format.raw/*7.81*/("""</a></h1>
  </div>
</section>

<div id="content" class="wrapper doc">
<article>

  <h1>Welcome to Play</h1>

  <p>
    Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
  </p>

  <blockquote>
    <p>
      You’re using Play """),_display_(/*22.26*/version),format.raw/*22.33*/("""
    """),format.raw/*23.5*/("""</p>
  </blockquote>

  <h2>Why do you see this page?</h2>

    <p>
      The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
      whenever a browser requests the <code>/</code> URI using the GET method:
    </p>

    <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>

    <p>
      Play has invoked the <code>controllers.HomeController.index</code> method to obtain the <code>Action</code> to execute:
    </p>

    <pre><code>def index = Action """),format.raw/*40.35*/("""{"""),format.raw/*40.36*/("""
  """),format.raw/*41.3*/("""Ok(views.html.index("Your new application is ready."))
"""),format.raw/*42.1*/("""}"""),format.raw/*42.2*/("""</code></pre>

    <p>
      An action is a function that handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
      Here we send a <code>200 OK</code> response, using a template to fill its content.
    </p>

    <p>
      The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a Scala function.
    </p>

    <pre><code>@(message: String)(implicit assetsFinder: AssetsFinder)

@main("Welcome to Play") """),format.raw/*55.27*/("""{"""),format.raw/*55.28*/("""

    """),format.raw/*57.5*/("""@welcome(message, style = "scala")

"""),format.raw/*59.1*/("""}"""),format.raw/*59.2*/("""</code></pre>

    <p>
      The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
      This template then calls another function defined in <code>app/views/main.scala.html</code>, which displays the HTML
      layout, and another function that displays this welcome message. You can freely add any HTML fragment mixed with Scala
      code in this file.
    </p>

    <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*68.86*/version),format.raw/*68.93*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*68.232*/version),format.raw/*68.239*/("""/ScalaActions">actions</a>.</p>



    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*73.87*/version),format.raw/*73.94*/("""/ScalaAsync">asynchronous actions</a> in the documentation.
    </p>

    <h2>Count Controller</h2>

    <p>
        Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you refresh the page, so keep refreshing to see the numbers go up.
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*83.87*/version),format.raw/*83.94*/("""/ScalaDependencyInjection">dependency injection</a> in the documentation.
    </p>

    <h2>Need more info on the console?</h2>

  <p>
    For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*89.187*/version),format.raw/*89.194*/("""/PlayConsole">Using the Play console</a>.
  </p>

  <h2>Need to set up an IDE?</h2>

  <p>
      You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
      including modifications made to Scala source files.
  </p>

  <p>
      If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
      <a href="https://www.playframework.com/documentation/"""),_display_(/*101.61*/version),format.raw/*101.68*/("""/IDE">Setting up your preferred IDE</a> page.
  </p>

  <h2>Need more documentation?</h2>

  <p>
    Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*107.94*/version),format.raw/*107.101*/("""">https://www.playframework.com/documentation</a>.
  </p>

  <p>
    Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
  </p>

  <h2>Need more help?</h2>

  <p>
    Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
  </p>

  <p>
    The <a href="https://discuss.playframework.com">Discuss Play Forum</a> is where Play users come to seek help,
    announce projects, and discuss issues and new features.
  </p>

  <p>
    Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
  </p>

</article>

<aside>
  <h3>Browse</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*134.59*/version),format.raw/*134.66*/("""">Documentation</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*135.59*/version),format.raw/*135.66*/("""/api/"""),_display_(/*135.72*/style),format.raw/*135.77*/("""/index.html">Browse the """),_display_(/*135.102*/{style.capitalize}),format.raw/*135.120*/(""" """),format.raw/*135.121*/("""API</a></li>
  </ul>
  <h3>Start here</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*139.59*/version),format.raw/*139.66*/("""/PlayConsole">Using the Play console</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*140.59*/version),format.raw/*140.66*/("""/IDE">Setting up your preferred IDE</a></li>
    <li><a href="https://playframework.com/download#examples">Example Projects</a>
  </ul>
  <h3>Help here</h3>
  <ul>
    <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
    <li><a href="https://discuss.playframework.com">Discuss Play Forum</a> </li>
    <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
  </ul>

</aside>

</div>
""")))}),format.raw/*153.2*/("""
"""))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/welcome.scala.html
                  HASH: 79f39aa966e392554b61f9bb28d7158d2fcbd5c8
                  MATRIX: 738->1|874->44|901->46|948->85|998->98|1026->100|1153->201|1180->208|1214->216|1241->223|1553->508|1581->515|1613->520|2201->1080|2230->1081|2260->1084|2342->1139|2370->1140|2881->1625|2910->1626|2943->1632|3006->1669|3034->1670|3580->2189|3608->2196|3775->2335|3804->2342|3960->2471|3988->2478|4650->3113|4678->3120|5027->3441|5056->3448|5562->3926|5591->3933|5809->4123|5839->4130|6948->5211|6977->5218|7088->5301|7117->5308|7151->5314|7178->5319|7232->5344|7273->5362|7304->5363|7440->5471|7469->5478|7601->5582|7630->5589|8120->6048
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|31->7|31->7|31->7|46->22|46->22|47->23|64->40|64->40|65->41|66->42|66->42|79->55|79->55|81->57|83->59|83->59|92->68|92->68|92->68|92->68|97->73|97->73|107->83|107->83|113->89|113->89|125->101|125->101|131->107|131->107|158->134|158->134|159->135|159->135|159->135|159->135|159->135|159->135|159->135|163->139|163->139|164->140|164->140|177->153
                  -- GENERATED --
              */
          