'use strict';

function f(x) {
    return x * x;
}

var arr = [1, 2, 3, 4, 5];
var x = [];
for (var i = 0; i < arr.length; i++) {
    x.push(f(arr[i]));
}

console.log(x);

var s = 'dsj';
s.sort();

function count() {
    var arr = [];
    for (var i=1; i<=3; i++) {
        arr.push((function (n) {
            return function () {
                return n * n;
            }
        })(i));
    }
    return arr;
}

// 定义数字0:
var zero = function (f) {
    return function (x) {
        return x;
    }
};

// 定义数字1:
var one = function (f) {
    return function (x) {
        return f(x);
    }
};

// 定义加法:
function add(n, m) {
    return function (f) {
        return function (x) {
            return m(f)(n(f)(x));
        }
    }
}


function loadXml(str) {
    var httpxml;
    if(str==''){
        document.getElementById("").innerText=str;
        return;
    }
    if(httpxml.XMLHttpRequest){
        httpxml = new XMLHttpRequest();
    }
    else {
        httpxml = new ActiveXObject();
    }
    httpxml.onreadystatechange = function () {
        if(httpxml.readyState==4&&status==200){
            document.getElementById('').innerHTML = httpxml.responseText;
        }
    }

    httpxml.open("GET","",true);
    httpxml.send();

}


var p1 = new Promise(test);
p1.then(function (value) {  }).catch(function (reason) {  });
