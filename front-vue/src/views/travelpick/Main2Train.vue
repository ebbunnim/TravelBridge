<template>
  <q-page padding class="full-width">
    <div class="row q-px-xl justify-center">
      <q-card class="col-6 q-pa-xl" flat bordered>
        <q-timeline :layout="layout" color="secondary">
          <q-timeline-entry heading>
            Timeline heading
            <br />
            <!-- ({{$q.screen.lt.sm ? 'Dense' : ($q.screen.lt.md ? 'Comfortable' : 'Loose')}} layout) -->
          </q-timeline-entry>

          <q-timeline-entry
            title="Event Title"
            subtitle="February 22, 1986"
            side="left"
          >
            <div>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
              nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
              reprehenderit in voluptate velit esse cillum dolore eu fugiat
              nulla pariatur. Excepteur sint occaecat cupidatat non proident,
              sunt in culpa qui officia deserunt mollit anim id est laborum.
            </div>
          </q-timeline-entry>
        </q-timeline>
      </q-card>
    </div>
  </q-page>
</template>

<script>
export default {
  data() {
    return {
      course: [{}]
    };
  },
  computed: {
    layout() {
      return this.$q.screen.lt.sm
        ? "dense"
        : this.$q.screen.lt.md
        ? "comfortable"
        : "loose";
    }
  }
};
</script>

<style></style>
