const routes = [
  {
    path: '/',
    component: () => import('layouts/TargetLayout.vue'),
    children: [
      {path: '', component: () => import('pages/HomePage.vue')},
      {path: '/Dashboard2', component: () => import('pages/Dashboard2.vue')},
      {path: '/Profile', component: () => import('pages/UserProfile.vue')},
      {path: '/Map', component: () => import('pages/Map.vue')},
      {path: '/MapMarker', component: () => import('pages/MapMarker.vue')},
      {path: '/TreeTable', component: () => import('pages/TreeTable.vue')},
      {path: '/StreetView', component: () => import('pages/StreetView.vue')},
      {path: '/Cards', component: () => import('pages/Cards.vue')},
      {path: '/Tables', component: () => import('pages/Tables.vue')},
      {path: '/Contact', component: () => import('pages/Contact.vue')},
      {path: '/Checkout', component: () => import('pages/Checkout.vue')},
      {path: '/Ecommerce', component: () => import('pages/ProductCatalogues.vue')},
      {path: '/Pagination', component: () => import('pages/Pagination.vue')},
      {path: '/Charts', component: () => import('pages/Charts.vue')},
      {path: '/Calendar', component: () => import('pages/Calendar.vue')},
      {path: '/Directory', component: () => import('pages/Directory.vue')},
      {path: '/Footer', component: () => import('pages/Footer.vue')},
      {path: '/CardHeader', component: () => import('pages/CardHeader.vue')},
      {path: '/test1', component: () => import('pages/Test1.vue')},
      {path: '/pageone', component: () => import('pages/PageOne.vue')},
      {path: '/testgantt', component: () => import('pages/GanttPageTest.vue')},
      {path: '/addproject', component: () => import('pages/AddProject.vue')} ,
      //{path: '/projectslist', component: () => import('pages/ProjectsList.vue')} ,
      {path: '/projectadd', component: () => import('pages/projects/ProjectAdd.vue')} ,
      {path: '/projectdetails/:id', component: () => import('pages/projects/ProjectDetails.vue')} ,
      {path: '/projectlist', component: () => import('pages/projects/ProjectList.vue')} ,

      {path: '/addmodule', component: () => import('pages/modules/AddModule.vue')} ,

      {path: '/homeboard', component: () => import('pages/dashboards/TestDashboard.vue')} ,
      {path: '/capacity', component: () => import('pages/members/Capacity.vue')} ,


      {path: '/projectboard', component: () => import('pages/dashboards/ProjectDashboard.vue')} ,
      {path: '/users', component: () => import('pages/members/UsersList.vue')} ,
      {path: '/testtest', component: () => import('pages/tasks/AllTasks.vue')},
      {path: '/library', component: () => import('pages/library/FilesLibrary.vue')},
      {path: '/filepdf', component: () => import('pages/library/FileTest.vue')}  ,
      {path: '/taskdetails/:id', component: () => import('pages/tasks/TaskDetails.vue')}  ,
      {path:'/testform' , component:()=> import ('pages/projects/TestP.vue')} ,
      {path:'/addtask' , component:()=> import ('pages/tasks/AddTask.vue')} ,
      {path:'/profilee' , component:()=> import ('pages/members/Profile.vue')} ,
      {path:'/k-board/:id' , component:()=> import ('pages/kanban/KanbanBoard.vue')} ,
      {path:'/testkanban' , component:()=> import ('pages/kanban/RealKanban.vue')} ,
      {path:'/projectdashboard' , component:()=> import ('pages/projects/ProjectDetailsBoard.vue')} ,
      {path:'/projects' , component:()=> import ('pages/projects/Project.vue')} ,
      {path:'/home' , component:()=> import ('pages/HomePage.vue')} ,














      // {path: '/Taskboard', component: () => import('pages/TaskBoard.vue')},
    ]
  },


  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue')
  },
  {
    path: '/lonetest',
    component: () => import('pages/LoneTest.vue')
  }
  ,
  {
    path: '/Mail',
    component: () => import('layouts/Mail.vue')
  },
  {
    path: '/Maintenance',
    component: () => import('pages/Maintenance.vue')
  },
  {
    path: '/Pricing',
    component: () => import('pages/Pricing.vue')
  },
  {
    path: '/Login-1',
    component: () => import('pages/Login-1.vue')
  },
  {
    path: '/logintarget',
    component: () => import('pages/LoginTeamwill.vue')
  },

  {
    path: '/Lock',
    component: () => import('pages/LockScreen.vue')
  },
  {
    path: '/Lock-2',
    component: () => import('pages/LockScreen-2.vue')
  },
  {path: '/login',
   component: () => import('pages/authentication/LoginTarget.vue')} ,

  {path: '/register',
   component: () => import('pages/authentication/RegisterTarget.vue')} ,
   {path: '/log', component: () => import('pages/log.vue')}


]

// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register', '/home'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');

//   // trying to access a restricted page + not logged in
//   // redirect to login page
//   if (authRequired && !loggedIn) {
//     next('/login');
//   } else {
//     next();
//   }
// });

export default routes
