//函数声明
function bool (a,d,e){
    if(sum.length>arguments.length){
        console.log('形参多了');
    }
   else if(sum.length<arguments.length){
        console.log('实参多了');
    }
    else{
        console.log('合理');
    }
}
//命名函数表达式
var test = function abc(){
    document.write(test.name,"<br/>");
}//输出函数名

//匿名函数表达式
var demo = function(){
    document.write(demo.name);
}//输出函数名

function sum (){
    var result= 0;
    for(var i=0;i<arguments.length;i++){
        result+=arguments[i];
    }
    console.log(result);
}

sum(123,123,123,123,123,123);
bool(123,123,123,123,123,123);
test();
demo();