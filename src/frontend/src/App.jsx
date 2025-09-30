import { useEffect, useState } from 'react'

function App() {
    const [users, setUsers] = useState([])
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    // Funkce pro načtení uživatelů
    const fetchUsers = () => {
        fetch('/users/all')
            .then(res => res.json())
            .then(data => setUsers(data))
    }

    useEffect(() => {
        fetchUsers()
    }, [])

    // Funkce pro odeslání nového uživatele
    const handleAddUser = (e) => {
        e.preventDefault()

        const params = new URLSearchParams({
            firstName,
            lastName,
            email,
            password
        })

        fetch('/users/add?' + params.toString(), { method: 'POST' })
            .then(res => res.json())
            .then(data => {
                // Přidat nového uživatele do seznamu
                setUsers(prev => [...prev, data])
                // Vymazat formulář
                setFirstName('')
                setLastName('')
                setEmail('')
                setPassword('')
            })
            .catch(err => console.error(err))
    }

    return (
        <div style={{ padding: '20px' }}>
            <h1>Seznam uživatelů</h1>

            {/* Formulář pro přidání uživatele */}
            <form onSubmit={handleAddUser} style={{ marginBottom: '20px' }}>
                <input
                    type="text"
                    placeholder="Jméno"
                    value={firstName}
                    onChange={e => setFirstName(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Příjmení"
                    value={lastName}
                    onChange={e => setLastName(e.target.value)}
                    required
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Heslo"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    required
                />
                <button type="submit">Přidat uživatele</button>
            </form>

            <table border="1" cellPadding="5">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Email</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                {users.map(u => (
                    <tr key={u.id}>
                        <td>{u.id}</td>
                        <td>{u.first_name}</td>
                        <td>{u.last_name}</td>
                        <td>{u.email}</td>
                        <td>{u.role}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default App