

//方式一：基于已有对象
var Student = {
    name:'666'||'无名',
    age:18||0,

    run:function () {
        alert('i aam running !');
    }
};

//使用Object创建对象
function createStudent(props) {
    //基于Student原型创建一个新的对象
    var s = Object.create(Student);
    //初始化
    s.name=props.name;
    s.age = props.age;

    return s;
}
//创建对象
var s2 = createStudent({name:'huahua',age:16});
var s3 = createStudent({name:'zhaosi',age:22});



//方式二：（基于构造器）构造函数原型
function Student(props){
    this.name = props.name;
    this.age = props.age;

    this.speak = function(){
        alert('i am ' +this.name+' !');
    }
}
Student.prototype.run = function(){
    alert('i am flying !');
}
//创建对象
var s = new Student({name:'zhaosi',age:22});
var s1 = new Student({name:'huahua',age:16});

//测试：
s.constructor === Student.prototype.constructor; // true
Student.prototype.constructor === Student; // true
Object.getPrototypeOf(s) === Student.prototype; // true
s instanceof Student; // true



//继承
// PrimaryStudent构造函数:
function PrimaryStudent(props) {
    Student.call(this, props);
    this.grade = props.grade || 1;
}

// 空函数F:
function F() {
}

// 把F的原型指向Student.prototype:
F.prototype = Student.prototype;

// 把PrimaryStudent的原型指向一个新的F对象，F对象的原型正好指向Student.prototype:
PrimaryStudent.prototype = new F();

// 把PrimaryStudent原型的构造函数修复为PrimaryStudent:
PrimaryStudent.prototype.constructor = PrimaryStudent;

// 继续在PrimaryStudent原型（就是new F()对象）上定义方法：
PrimaryStudent.prototype.getGrade = function () {
    return this.grade;
};

// 创建xiaoming:
var xiaoming = new PrimaryStudent({
    name: '小明',
    grade: 2
});
xiaoming.name; // '小明'
xiaoming.grade; // 2

// 验证原型:
xiaoming.__proto__ === PrimaryStudent.prototype; // true
xiaoming.__proto__.__proto__ === Student.prototype; // true

// 验证继承关系:
xiaoming instanceof PrimaryStudent; // true
xiaoming instanceof Student; // true


