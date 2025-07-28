import { useState, useEffect } from 'react';
import { getUsers, deleteUser } from '../services/apiUser';

export default function useUsers() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [erro, setErro] = useState(null);

  const loadUsers = async () => {
    try {
      setLoading(true);
      const dados = await getUsers();
      setUsers(dados);
      setErro(null);
    } catch (err) {
      setErro(err.message);
    } finally {
      setLoading(false);
    }
  };

  const excludeUser = async (id) => {
    try {
      await deleteUser(id);
      setUsers((prev) => prev.filter((u) => u.id !== id));
    } catch (err) {
      setErro(err.message);
    }
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return { users, loading, erro, excludeUser };
}
