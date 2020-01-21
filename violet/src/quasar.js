import Vue from "vue";

import "./styles/quasar.sass";
import "@quasar/extras/material-icons/material-icons.css";
import {
  Quasar,
  QLayout,
  QHeader,
  QDrawer,
  QPageContainer,
  QPage,
  QToolbar,
  QToolbarTitle,
  QBtn,
  QIcon,
  QList,
  QItem,
  QItemSection,
  QItemLabel,
  QFooter,
  QCard,
  QCardSection,
  QSeparator,
  QRouteTab,
  QTabs,
  QSpace,
  QExpansionItem,
  QCarousel,
  QCarouselControl,
  QCarouselSlide,
  QImg,
  QScrollArea,
  QInput
} from "quasar";

Vue.use(Quasar, {
  config: {},
  components: {
    QLayout,
    QHeader,
    QDrawer,
    QPageContainer,
    QPage,
    QToolbar,
    QToolbarTitle,
    QBtn,
    QIcon,
    QList,
    QItem,
    QItemSection,
    QItemLabel,
    QFooter,
    QCard,
    QCardSection,
    QSeparator,
    QRouteTab,
    QTabs,
    QSpace,
    QExpansionItem,
    QCarousel,
    QCarouselControl,
    QCarouselSlide,
    QImg,
    QScrollArea,
    QInput
  },
  directives: {},
  plugins: {}
});
