// import { useState } from 'react'
import WishList from "./pages/Wishlist";
import OwnedList from "./pages/OwnedList";
// import "./App.css";
// import Foot from "./components/Footer/Foot";
// import Layout from "./components/Navbar/Layout";
// import { Route, Routes } from "react-router-dom";
// import Login from "./pages/Login";
// import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
// import Homepage from './components/Homepage';
// import LoginPage from './components/LoginPage';
// import SignupPage from './components/SignupPage';

function App() {
  return (
    <>
      <WishList />
      <div>=========================== </div>
      <OwnedList />
      {/* <Router>
      <Switch>
        <Route path="/" exact component={Homepage} />
        <Route path="/login" component={LoginPage} />
        <Route path="/signup" component={SignupPage} />
        <Route path="/owned-list" component={<OwnedList/>} />
        <Route path="/wish-list" component={<WishList/>} />
      </Switch>
    </Router> */}
    </>
  );
}

// function App() {

//   return (
//     <>
//         {/* <Layout> */}
//         <WishList/>
//         <div>===========================  </div>
//         <OwnedList/>
//           <Login></Login>
//           <Routes>
//           <Route path="/" element={<Login/>} />
//           <Route path="/home" element={<Homepage />} />
//           <Route path="/discover" element={<Discover />} />
//           {<Route path="/wish-list" element={<WishList/>} />}
//           <Route path="/owned-list" element={<OwnedList/>} />
//         </Routes>
//         </Layout>
//     </>
//   );
// }

export default App;
