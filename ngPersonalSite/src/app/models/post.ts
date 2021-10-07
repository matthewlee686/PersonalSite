import { User } from "./user";

export class Post {

  id : number;
	title : string;
	postDate : string;
	postContent : string;
  user : User;

  constructor(
  id = 0,
  title = '',
  postDate  = '',
  postContent = '',
  user = new User()
  ) {
    this.id = id;
    this.title = title;
    this.postDate  = postDate ;
    this.postContent= postContent;
    this.user = user;
  }

}
