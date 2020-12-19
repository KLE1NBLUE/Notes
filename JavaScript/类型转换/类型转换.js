//强制类型转换方法 Number（）、parseInt（）、String（）、Boolean（）等
var arr = new Array();
arr[0] = Number("9"); //转为数字
arr[1] = Number("1");
arr[2] = Number(undefined);
arr[3] = Number(null);
arr[4] = Number(function () {});
arr[5] = Number(9 > 0);
arr[6] = Number("_123");
arr[7] = parseInt("_123"); //转为整型
arr[8] = parseInt("123px"); //返回连续的数字位
arr[9] = parseFloat("123.2px"); //返回连续的数字位
arr[10] = String(123); //转为字符串
arr[11] = String(undefined);
arr[12] = String(null);
arr[13] = Boolean(123); //转为布尔
arr[14] = Boolean("abc");
arr[15] = Boolean(undefined);
arr[16] = Boolean(null);
arr[17] = Boolean(function () {});


for (var index in arr) {
    document.write(typeof (arr[index]) + " : " + arr[index], "<br/>");
}


var a = 123;
var b = a.toString(8); //转换为 8 进制的字符串表现形式。
var c = parseInt(b, 8);
document.write(typeof (b) + " : " + b, "<br/>");
document.write(typeof (c) + " : " + c, "<br/>");
//隐式类型转换
for (var index in arr) {
    //isNaN 方法是先把参数转为数字后，再进行判断。也就是隐式转换为数字。
    document.write(isNaN(arr[index]) + " : " + arr[index], "<br/>");
}
var d = false == 0;
var dd = 1 == "1";
var ddd = 1 === "1"; //绝对比较符 不进行隐式类型转换
var e = NaN == NaN;
var f = undefined == null;
var g = NaN == undefined;

document.write(typeof (d) + " : " + d, "<br/>");
document.write(typeof (dd) + " : " + dd, "<br/>");
document.write(typeof (ddd) + " : " + ddd, "<br/>");
document.write(typeof (e) + " : " + e, "<br/>");
document.write(typeof (f) + " : " + f, "<br/>");
document.write(typeof (g) + " : " + g, "<br/>");