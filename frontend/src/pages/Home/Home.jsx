import React from 'react';
import { Box, Button, Container, Typography, Stack } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import Layout from '../../components/layouts/MainLayout';

export default function Home() {
  const navigate = useNavigate();

  const handleGoToUsers = () => {
    navigate('/users');
  };

  const handleLogout = () => {
    // Aqui você pode limpar localStorage, tokens, etc.
    // Ex: localStorage.removeItem('token');
    navigate('/');
  };

  return (
    <Layout>
        <Container maxWidth="md">
        <Box
            sx={{
            marginTop: 10,
            textAlign: 'center',
            }}
        >
            <Typography variant="h4" gutterBottom>
            Hola, Mundo!
            </Typography>

            <Stack spacing={2} direction="row" justifyContent="center"></Stack>
        </Box>
        </Container>
    </Layout>
  );
}