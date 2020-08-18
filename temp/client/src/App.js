import React/*{ useState }*/ from 'react';
import { Route, Switch } from 'react-router-dom'
import LoginComponent from './components/login/Login'
import HomePage from './components/home/HomePage';
//import * as styles from './App.module.css'

function App() {

  return (
    <div>
      <Switch>
        <Route path= {`/login`} component={LoginComponent} />
        <Route path={`/`}  component={HomePage}/>
  Í   </Switch>
    </div>
  );
}

export default App;
