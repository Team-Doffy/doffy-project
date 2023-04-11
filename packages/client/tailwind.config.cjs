/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      height: {
        "100": "6.25rem",
        "165": "10.313rem",
        "220": "13.75rem",
      },
      padding: {
        "180": "11.25rem",
      },
      gridTemplateColumns: {
        'community-main': '14.75rem 82.2%',
      },
      gridTemplateRows: {
        'community-main': '100%'
      }
    },
  },
  plugins: [],
}
