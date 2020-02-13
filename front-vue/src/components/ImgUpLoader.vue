<template>
  <div>
    <q-uploader
      label="Custom header"
      extensions=".gif,.jpg,.jpeg,.png"
      multiple
      @added="file_selected"
      style="min-height: 30rem;"
      flat
      bordered
    >
      <template v-slot:header="scope">
        <div class="row no-wrap items-center q-pa-sm q-gutter-xs">
          <q-btn
            v-if="scope.queuedFiles.length > 0"
            icon="clear_all"
            @click="scope.removeQueuedFiles"
            round
            dense
            flat
          >
            <q-tooltip>Clear All</q-tooltip>
          </q-btn>
          <q-btn
            v-if="scope.uploadedFiles.length > 0"
            icon="done_all"
            @click="scope.removeUploadedFiles"
            round
            dense
            flat
          >
            <q-tooltip>Remove Uploaded Files</q-tooltip>
          </q-btn>

          <div class="col">
            <div class="q-uploader__title">Upload your files</div>
            <div
              class="q-uploader__subtitle"
            >{{ scope.uploadSizeLabel }} / {{ scope.uploadProgressLabel }}</div>
          </div>
          <q-btn v-if="scope.canAddFiles" type="a" icon="add_box" round dense flat>
            <q-uploader-add-trigger />
            <q-tooltip>Pick Files</q-tooltip>
          </q-btn>
        </div>
      </template>
    </q-uploader>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected_file: []
    };
  },
  methods: {
    file_selected(file) {
      console.log(file);
      this.selected_file = file;
      console.log(this.selected_file);
      //이 버튼 필요없고 글쓰기 버튼누르면 글쓰면서 이 친구들 대리고가야한다.
    }
  }
};
</script>

<style>
</style>