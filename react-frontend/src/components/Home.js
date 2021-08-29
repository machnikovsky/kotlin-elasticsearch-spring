import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
        <div className="modules">
            <div className="links">
                <Link to="/search">Search</Link>
                <Link to="/add">Add</Link>
            </div>
        </div>
      );
}

export default NavBar;
