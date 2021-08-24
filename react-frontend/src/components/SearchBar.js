import { useState, useEffect } from "react";

const SearchBar = () => {

    const [username, setUsername] = useState('');
    const [users, setUsers] = useState(null);

    useEffect(() => {
        const abortController = new AbortController();

        fetch(`http://kotlin-backend:8080/blogger/match/${username}`, {
            signal: abortController.signal,
            method: 'GET'
        })
        .then(res => {
                return res.json();
         })
        .then(data => {
            setUsers(data);
        })
        .catch(e => {
            setUsers(null)
        });
    }, [username])

    return (
        <div>
            <form>
                <label>Enter an username: </label>
                <input
                    type="text"
                    required
                    value={username}
                    placeholder="Username..."
                    onChange={e => setUsername(e.target.value)}
                />
                <button type="submit">Search</button>
            </form>
            { users && (
                    users.map(u => (
                        <div className="user" key= { u.bloggerId }>
                            <p>{u.firstName} {u.lastName} {u.email}</p>
                        </div>
                    ))
                
            )}
        </div>
    );
};

export default SearchBar;