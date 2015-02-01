<!DOCTYPE html>
<html>
<head>
<script src="components/jquery/jquery.min.js" type="text/javascript"></script>
<script src="components/bootsrap2/js/corgi.js" type="text/javascript"></script>
<script src="components/bootsrap2/js/html5shiv.js" type="text/javascript"></script>
<script src="components/bootsrap2/js/bootstrap.js" type="text/javascript"></script>
<script src="components/bootsrap2/js/bootstrap.min.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
    $("#div1").remove();
  });
});
</script>
</head>
<body>

<div id="div1" style="height:100px;width:300px;border:1px solid black;background-color:yellow;">

This is some text in the div.
<p>This is a paragraph in the div.</p>
<p>This is another paragraph in the div.</p>

</div>
<br>
<button>Remove div element</button>

</body>
</html>
