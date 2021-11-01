<script>
  let name = "";
  let username = "";
  let email = "";
  let password = "";
  let password2 = "";
  const handleSubmit = () => {
    console.log("Handling it");
    if (password == password2) {
        password = "Does not match"
    }
    else{
        
    }
  };
</script>

<body>
  <div class="card">
    <h2>Sign up</h2>
    <div class="row">
      <div class="col">
        <div class="form-group">
          <!-- svelte-ignore a11y-label-has-associated-control -->
          <label>Name</label>
          <input bind:value={name} type="text" placeholder="Stephen Okita" />
        </div>
      </div>

      <div class="col">
        <div class="form-group">
          <!-- svelte-ignore a11y-label-has-associated-control -->
          <label>Username</label>
          <input bind:value={username} type="text" placeholder="TheArctesian" />
        </div>
      </div>

      <div class="col">
        <div class="form-group">
          <!-- svelte-ignore a11y-label-has-associated-control -->
          <label>Email</label>
          <input
            bind:value={email}
            type="text"
            placeholder="Arctesian@guerrillamail.com"
            name="email"
          />
        </div>
      </div>

      <div class="col">
        <div class="form-group">
          <!-- svelte-ignore a11y-label-has-associated-control -->
          <label>Password</label>
          <input type="password" bind:value={password} />
        </div>
      </div>

      <div class="col">
        <div class="form-group">
          <!-- svelte-ignore a11y-label-has-associated-control -->
          <label>Confirm Password</label>
          <input type="password" bind:value={password2} />
        </div>
      </div>

      <div class="col">
        <form on:submit|preventDefault={handleSubmit}>
          <input type="submit" value="Submit" />
        </form>
      </div>
    </div>
  </div>
</body>

<style>
  @import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap");
  @import url("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
  * {
    margin: 0;
    padding: 0;
  }

  body {
    height: 100vh;
    background: #b9d9f3;
    font-family: "Press Start 2P", cursive;
  }

  body {
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .card {
    width: 70%;
    padding: 30px 90px 90px 90px;
    border: 6px solid rgba(0, 0, 0, 0.3);
    box-shadow: 20px 20px 0 rgba(0, 0, 0, 0.3);
    border-radius: 50px;
    position: relative;
  }

  .card h2 {
    color: rgba(255, 0, 13, 0.582);
    font-size: 60px;
    text-transform: uppercase;
  }

  .card .row {
    position: relative;
    width: 100%;
    display: grid;
    grid: auto / auto auto;
    grid-template-columns: repeat(auto-fit, minmax(40%, 1fr));
    grid-gap: 30px;
  }

  .card .row .col {
    position: relative;
    width: 100%;
    margin: 30px 20px 40px 0;
    transition: 0.5s;
  }

  .card .row .form-group {
    position: relative;
    width: 100%;
    height: 40px;
    color: #ffffff;
  }

  .card .row .form-group input {
    position: absolute;
    width: 90%;
    height: 100%;
    background: transparent;
    outline: none;
    font-size: 24px;
    padding: 10px 0 10px 20px;
    border: 5px solid rgba(0, 0, 0, 0.3);
    box-shadow: 10px 10px 0 rgba(0, 0, 0, 0.3);
    color: #ffffff;
    border-radius: 50px;
  }

  .card .row .form-group label {
    line-height: 40px;
    color: #ffffff;
    font-size: 24px;
    margin: 0 0 0 30px;
    display: block;
    pointer-events: none;
  }

  .row .col:nth-child(6) {
    margin-top: 64px;
  }

  .card .row .form-group input:focus {
    border: 5px solid #f8550a;
    transition: all 0.5s;
  }

  .card .row input[type="submit"] {
    border: 5px solid rgba(0, 0, 0, 0.3);
    box-shadow: 10px 10px 0 rgba(0, 0, 0, 0.3);
    padding: 10px;
    height: 100%;
    width: 50%;
    cursor: pointer;
    outline: none;
    background: transparent;
    text-transform: uppercase;
    color: #ffffff;
    line-height: 40px;
    font-size: 24px;
    font-weight: 700;
    border-radius: 45px;
    transition: all 0.4s;
  }

  .card .row input[type="submit"]:hover {
    border: 5px solid rgba(255, 255, 255, 1);
    color: #6b6b6b;
    transition: all ease in out 0.4s;
  }

  input[type="text"] {
    font-family: "Press Start 2P", cursive;
  }
  @media screen and (max-width: 900px) {
    .card .row {
      transform: translateY(-10px);
      grid-template-columns: repeat(auto-fit, minmax(50%, 1fr));
    }

    .card {
      padding: 20px;
    }

    .card h2 {
      font-size: 34px;
    }

    .card .row input[type="submit"] {
      width: 100%;
    }
  }
</style>
