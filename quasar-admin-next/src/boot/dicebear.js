import { createAvatar } from '@dicebear/core';
import{ initials } from '@dicebear/collection';

export default ({ app }) => {
  app.config.globalProperties.$dicebear = {
    generateAvatar(seed) {
      const svg = createAvatar(initials, {
        seed,
        radius: 50,
        backgroundColor: ["7cb342"]
        // Customize avatar options here
      });
      return svg;
    }
  };
};