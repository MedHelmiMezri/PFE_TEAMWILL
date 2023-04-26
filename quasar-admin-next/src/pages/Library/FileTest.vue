<template>
  <div class="row q-gutter-lg">
    <div class="col">
      <q-card style="height:100px">
        <q-btn label="PDF File 1" @click="loadPdfFile(pdfFile)" />
        <q-btn label="PDF File 2" @click="loadPdfFile(pdf1)" />
      </q-card>
    </div>
    <div class="col">
      <q-card class="bg-grey">
        <div class="pdf-container">
          <embed class="pdf-viewer" :src="pdfData" type="application/pdf" />
        </div>
      </q-card>
    </div>
  </div>
</template>

<script>
import pdfFile from './pdftest.pdf';
import pdf1 from './sample.pdf';

export default {
  data() {
    return {
      pdfData: null,
      pdfFile,
      pdf1,
    };
  },
  mounted() {
    this.loadPdfFile(this.pdfFile);
  },
  methods: {
    loadPdfFile(pdf) {
      // Load the PDF file and encode it as a base64 string
      fetch(pdf)
        .then((response) => response.blob())
        .then((blob) => {
          const reader = new FileReader();
          reader.onload = () => {
            this.pdfData = reader.result;
          };
          reader.readAsDataURL(blob);
        });
    },
  },
};
</script>

<style>
.pdf-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.pdf-viewer {
  width: 90%;
  height: 90%;
}
</style>
