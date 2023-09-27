// import React from 'react';
import { Routes, Route } from 'react-router-dom';

import HomePage from './pages/HomePage';
import LoginPage from './components/LoginPage';
import SignupPage from './components/SignupPage';
import Layout from './components/Navbar/Layout';
import UserProfile from './pages/UserProfile';
import DiscoverySearch from './pages/Discovery';
// import OwnedList from './pages/OwnedList';
// import WishList from './pages/WishList';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<SignupPage />}/>
        <Route path="/discover" element={<DiscoverySearch />}/>
        {/* <>
          <Routes>
          <Route exact path="/" component={OwnedList} />
        <Route path="/another-page" component={WishList} />
          </Routes>
          </> */}
        <Route path="/user-detail" element={<UserProfile />} />
      </Routes>
      </Layout>
    
  );
}

export default App;



