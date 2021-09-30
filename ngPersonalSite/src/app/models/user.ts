export class User {

  id : number;
	email : string;
	username : string;
	password : string;
  role : string;

  constructor(
  id = 0,
  email = '',
  username = '',
  password = '',
  role = ''
  ) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = role;
  }

}
