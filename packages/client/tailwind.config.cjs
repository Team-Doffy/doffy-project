/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      height: {
        "100": "6.25rem",
        "165": "10.313rem"
      }
    },
  },
  plugins: [],
}
