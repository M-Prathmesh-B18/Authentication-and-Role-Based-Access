const Signup = () => {
  return (
    <form>
      <label for="uname">UserName</label>
      <input type="text" placeholder="UserName" id="uname" />

      <label for="uemail">Email</label>
      <input type="email" placeholder="Email" id="uemail" />

      <label for="i=upass">Password</label>
      <input type="password" placeholder="Password" id="upass" />

      <button>
        <input type="submit" placeholder="SignUp" />
      </button>
    </form>
  );
};
export default Signup;
