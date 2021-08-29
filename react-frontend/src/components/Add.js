import { useState } from "react";
import { useHistory } from "react-router-dom";


const Add = () => {
    
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [isPending, setIsPending] = useState(false);
    const history = useHistory();


    const handleSubmit = (e) => {
        e.preventDefault();
        const blogger = {firstName, lastName, email};

        setIsPending(true);

        fetch('/blogger', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(blogger)
        }).then(() => {
            setIsPending(false);
            history.push('/');
        })
    }


    return ( 
        <div className="add">
            <h2>Add a new Blogger</h2>
            <form onSubmit={handleSubmit}>
                <label>First name:</label>
                <input
                    type="text"
                    required
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                />
                <label>Last name:</label>
                <textarea 
                    required
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                ></textarea>
                <label>Email:</label>
                <textarea 
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                ></textarea>
                { !isPending && <button>Add a blogger</button> }
                { isPending && <button disabled>Adding bloger...</button> }
            </form>
        </div>
     );



}

export default Add;