<template>
  <div>
    <q-footer class="footer bg-white text-grey border">
      <div class="footer">
        <div class="row">
          <div class="card">
            <p class="text-h6 text-bold">Customer Service</p>
            <p>
              <router-link class="link" to="/">Q&A</router-link>
            </p>
            <p class="subtitle">
              <router-link class="link" to="/">FAQ</router-link>
            </p>
          </div>
          <div class="card">
            <p class="text-h6 text-bold">About Team</p>
            <p>
              <router-link class="link" to="/">About project</router-link>
            </p>
            <p>
              <router-link class="link" to="/">About members</router-link>
            </p>
          </div>
          <div class="card">
            <p class="text-h6 text-bold">About Team</p>
            <p>
              <router-link class="link" to="/">About project</router-link>
            </p>
            <p>
              <router-link class="link" to="/">About members</router-link>
            </p>
            <p>
              <router-link class="link" to="/">About project</router-link>
            </p>
          </div>
        </div>
      </div>
    </q-footer>
  </div>
</template>

<script>
export default {
  name: "MyLayout",
  data() {
    return {
      leftDrawerOpen: false
    };
  }
};
</script>

<style>
.link {
  text-decoration: none;
  color: #9e9e9e;
}

.footer {
  margin-left: 0;
  margin-right: 0;
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 2%;
  padding-bottom: 3%;
}
.border {
  border-block-color: black;
  border-top-style: solid;
  border-top-width: thin;
  border-top-color: grey;
}
.footer-title {
  font-size: 100px;
}

.card {
  padding-left: 2%;
  display: inline-block;
  width: 33%;
  height: 40%;
  vertical-align: top;
}
</style>