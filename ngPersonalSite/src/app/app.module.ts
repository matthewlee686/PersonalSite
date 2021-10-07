import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AboutComponent } from './components/about/about.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { ContactComponent } from './components/contact/contact.component';
import { ResumeComponent } from './components/resume/resume.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { Com323Component } from './components/com323/com323.component';
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ModalModule } from 'ngx-bootstrap/modal';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { PostsService } from './services/posts.service';
import { LogoutComponent } from './components/logout/logout.component';
// import { ParticlesModule } from 'angular-particle';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    ProjectsComponent,
    ContactComponent,
    ResumeComponent,
    NotFoundComponent,
    Com323Component,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule.forRoot(),
    BrowserAnimationsModule,
    ModalModule.forRoot(),
    PdfViewerModule,
    HttpClientModule,
    FormsModule,
    // ParticlesModule
  ],
  providers: [
    AuthService,
    PostsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
