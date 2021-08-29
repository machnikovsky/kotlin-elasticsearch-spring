import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
      <div className="wrapper">
        <div className="nav-bar">
            <div className="logo">
              <Link to="/">zajavva</Link>
            </div>
        </div>
      </div>
      );
}

export default NavBar;
