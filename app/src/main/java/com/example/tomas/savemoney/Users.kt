package com.example.tomas.savemoney

class Users {

    var id: String? = null
    var email: String? = null
    var senha: String? = null

    constructor(){

    }

    constructor(email: String?, id:String?){
        this.email = email
        this.id = id

    }
    constructor(email: String?, id:String?, senha:String?){

        this.email = email
        this.id = id
        this.senha = senha
    }



}
