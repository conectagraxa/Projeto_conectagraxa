import { Navigate, Routes, Route } from 'react-router-dom';

export default function PrivateRoute({ Component }) {
  if(localStorage.getItem('id') == null ||localStorage.getItem('id') == '' ) { 
    return <Navigate to="/" />
}

 return <Component />;

}