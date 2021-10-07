import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { AuthService } from 'src/app/services/auth.service';
import { PostsService } from 'src/app/services/posts.service';

@Component({
  selector: 'app-com323',
  templateUrl: './com323.component.html',
  styleUrls: ['./com323.component.css']
})
export class Com323Component implements OnInit {

  constructor(
    private postSvc: PostsService,
    private auth: AuthService
    ) { }

  posts: Post[] = [];

  ngOnInit(): void {
    this.index();
  }

  index() {
    this.postSvc.index().subscribe(
      data => {
        this.posts = data;
      },
      fail => {
        console.log("Error retrieving posts")
      }
    )
  }

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }

}
