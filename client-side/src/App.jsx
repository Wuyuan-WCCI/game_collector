import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import HomePage from './pages/HomePage';
import LoginPage from './components/LoginPage';
import SignupPage from './components/SignupPage';
import UserDetail from './pages/UserDetail';
import Layout from './components/Navbar/Layout';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<SignupPage />} />
        <Route path="/user-detail" element={<UserDetail />} />
      </Routes>
      </Layout>
    
  );
}

export default App;



