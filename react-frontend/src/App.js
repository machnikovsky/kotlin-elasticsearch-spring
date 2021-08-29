import './App.css';
import NavBar from './components/NavBar';
import SearchBar from './components/SearchBar';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Add from './components/Add';

const App = () => {
  return (
    <Router>
      <div className="App">
        <NavBar />
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/search">
              <SearchBar />
            </Route>
            <Route path="/add">
              <Add />
            </Route>
          </Switch>      
      </div>
    </Router>
  );
}

export default App;
