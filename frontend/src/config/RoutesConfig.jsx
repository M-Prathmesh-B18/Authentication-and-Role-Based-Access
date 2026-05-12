import { Route, Routes } from "react-router-dom";
import App from "../App";
import Signup from "../signup";
import Signin from "../Signin";

const MyRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<App />} />
      <Route path="/signin" element={<Signin />} />
      <Route path="/signup" element={<Signup />} />
    </Routes>
  );
};
export default MyRoutes;
