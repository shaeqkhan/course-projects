<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello, jQTouch</title>

    <style type="text/css" media="screen">@import "jqtouch/jqtouch.css";</style>
    <style type="text/css" media="screen">@import "themes/apple/theme.css";</style>
    <script src="jqtouch/jquery-1.4.2.js" type="text/javascript" charset="utf-8"></script>
    <script src="jqtouch/jqtouch.js" type="application/x-javascript" charset="utf-8"></script

    <!-- JavaScript goes here -->
    <script type="text/javascript">
      // Fire up JQTouch
      $.jQTouch({
        statusBar: 'black'
      });
    </script>

    <!-- CSS styles -->
    <style type="text/css" >

    </style>
  </head>

  <!-- UI definition goes here -->
  <!-- A simple JQTouch layout consisting of two views -->
<body>
  <!-- "Page 1" -->
  <div id="theform">
    <div class="toolbar">
      <h1>TweetMe</h1>
    </div>
    <ul class="rounded">
      <li>Hello World</li>
      <li><a href="#tweets">Go to view 2</a></li>
    </ul>
  </div>

  <!-- "Page 2" - Will contain the tweets found -->
  <div id="tweets">
    <div class="toolbar">
      <h1>Results</h1>
      <a class="back" href="#">Back</a>
    </div>
    <ul id="results_ul" class="rounded">
      <li>This is page 2</li>
    </ul>
  </div>

</body>
</html>