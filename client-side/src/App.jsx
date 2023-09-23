// import { useState } from 'react'
import WishList from "./pages/Wishlist";
import OwnedList from "./pages/OwnedList";
// import "./App.css";
// import Foot from "./components/Footer/Foot";
import Layout from "./components/Navbar/Layout";
import { Route, Routes } from "react-router-dom";  // May need to import {Switch}
import Login from "./pages/Login";

// import Homepage from './components/Homepage';
// import LoginPage from './components/LoginPage';
// import SignupPage from './components/SignupPage';

function App() {
  return (
    <>
          <Layout>
      <Routes>
      {/* <Switch> */}
        {/* <Route path="/" exact component={Homepage} /> */}
        <Route path="/login" element={<Login />} />
        {/* <Route path="/signup" component={SignupPage} /> */}
        <Route path="/owned-list" element={<OwnedList/>} />
        <Route path="/wish-list" element={<WishList/>} />
      {/* </Switch> */}
    </Routes>
    </Layout>

    {/* <Login />
    <br></br>
    <div>=========================== </div>
      <WishList />
      <div>=========================== </div>
      <OwnedList /> */}
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
