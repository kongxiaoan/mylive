package com.kpa.mylive.test

/**
 * @author      kongpingan
 * @date        2022/4/13 6:39 下午
 * @package     com.kpa.mylive.test
 * @description
 **/
class Person {
    var name: String = ""
    var age: Int = 0

    constructor()

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "name = $name, age = $age"
    }
}