# Chrome for ScalaJS [![Build Status](https://travis-ci.org/lucidd/scala-js-chrome.svg?branch=master)](https://travis-ci.org/lucidd/scala-js-chrome) [![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/lucidd/scala-js-chrome?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

The goal of this project is to provide an easy and typesafe way to create chrome
apps and extensions in scala using the scalajs project.

## Chrome API bindings

The bindings provide access to the chrome app and extension APIs. There are two
levels for each API. One that provides the raw javascript bindings and a second
one which wraps the raw API in a more scala idiomatic way.

The package structure is similar to the original javascript API.

```javascript
//original javascript
chrome.system.cpu.getInfo(function(info){
  if (chrome.runtime.lastError === undefined) {
    console.log(info);
  } else {
    console.log("ohoh something went wrong!");
  }
});
```
```scala
//raw bindings
chrome.system.cpu.bindings.CPU.getInfo((info: CPUInfo) => {
    if (chrome.runtime.bindings.Runtime.lastError.isEmpty) {
        println(info)
    } else {
        println("ohoh something went wrong!")
    }
})

//scala idiomatic way using Future
chrome.system.cpu.CPU.getInfo.onComplete {
  case Success(info) => println(info)
  case Failure(error) => println("ohoh something went wrong!")
}
```

The scala idiomatic binding provieds the following general changes:

- Futures instead of callbacks
- Error handling using types like `Future` / `Try` instead of global error 
varibale.
- Using `Option` for things that may or may not be defined.

## SBT Plugin

The job of the SBT plugin is to help with common tasks for developing chrome
apps/extensions. It also provides a way to configure your app/extension in your
SBT file and automatically generate the manifest file.

- `chromePackage` will create a ZIP file you can upload to the chrome store.
- `chromeBuildOpt` will build your projects with optimizations enabled. The
output will be in `target/chrome/unpacked` and can be loaded by chrome as an
unpacked extension/app.

## Getting Started

Add this to your `project/plugins.sbt`
```scala
addSbtPlugin("net.lullabyte" % "sbt-chrome-plugin" % "0.3.0")
```

Add this to your projects dependencies
```scala
"net.lullabyte" %%% "scala-js-chrome" % "0.3.0"
```

### Creating a basic Window

```scala
import chrome.app.runtime.bindings.LaunchData
import chrome.app.window.Window
import utils.ChromeApp

import scalajs.concurrent.JSExecutionContext.Implicits.queue

object ChromeAppExample extends ChromeApp {

  override def onLaunched(launchData: LaunchData): Unit = {
    println("hello world from scala!")
    Window.create("assets/html/App.html").foreach { window =>
      /**
         Access to the document of the newly created window.
         From here you can change the HTML of the window with whatever
         library you want to use.
      */
      window.contentWindow.document
    }
  }

}
```
For a more complete example see https://github.com/lucidd/chrome-system-monitor.

### UI Libraries

There are already multiple libraries to manipulate HTML and build your UI
available for ScalaJS.

- [scala-js-dom](https://github.com/scala-js/scala-js-dom) For simple dom access
- [scalatags](https://github.com/lihaoyi/scalatags) Scala DSL for creating HTML
- [scalajs-react](https://github.com/japgolly/scalajs-react) Bindings for using react.js
- [scalacss](https://github.com/japgolly/scalacss) Typesafe way to write CSS
  with Scala


### Known Issues

In chrome apps and extensions there are multiple places where you can run
javascript. Normaly you split your logic into different files and load them into
whatever context they need to run. Since ScalaJS compiles your whole project
into one big file all contexts need to load this big file with all the logic
even if they only need a smell subset. This can cause your app you use more
memory then it need to. In some cases this can be worked around for example the
a background page can manipulate the DOM of a App window so you don't need any
javascript at all in the window itself.
