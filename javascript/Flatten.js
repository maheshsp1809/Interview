function flattenObject(obj, parentKey = "", result = {}) {
  for (let key in obj) {
    if (obj.hasOwnProperty(key)) {
      const newKey = parentKey ? `${parentKey}.${key}` : key;

      if (typeof obj[key] === "object" && obj[key] !== null) {
        // Recursively flatten the nested object
        flattenObject(obj[key], newKey, result);
      } else {
        // Add the flattened key-value pair to the result
        result[newKey] = obj[key];
      }
    }
  }
  return result;
}

const obj = {
  a: 1,
  b: {
    c: 2,
    d: {
      e: 3,
      f: 4,
    },
  },
  g: 5,
};

console.log(flattenObject(obj));
