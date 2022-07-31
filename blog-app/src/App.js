
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Base from './components/Base';
import{BrowserRouter,Routes, Route} from 'react-router-dom'
import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Newsignup from './pages/Newsignup';
import Userdashboard from './pages/user-routes/Userdashboard';
import Privateroute from './components/Privateroute';
import Profileinfo from './pages/user-routes/Profileinfo';

function App() {
  return (
    <BrowserRouter>
    
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/newsignup' element={<Newsignup/>}/>

        <Route path='/user' element={<Privateroute/>}>
        <Route path='dashboard' element={<Userdashboard/>}/>
        <Route path='profile-info' element={<Profileinfo/>}/>
        </Route>
        

      </Routes>
    
    </BrowserRouter>
  


  );
}

export default App;
