package com.evarion.library.librarySqlJTableRequesst;


// create a users class

    class Users {
        private int Id;
        private String Fname;
        private String Lname;
        private int Age;

        public Users(int id,String fname,String lname,int age){
            this.Id = id;
            this.Fname = fname;
            this.Lname = lname;
            this.Age = age;
        }

        public int getId(){
            return this.Id;
        }

        public String getFname(){
            return this.Fname;
        }

        public String getLname(){
            return this.Lname;
        }

        public int getAge(){
            return this.Age;
        }
    }


