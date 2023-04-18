/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      width: {
        27: "1.688rem",
      },
      height: {
        18: "1.125rem",
        100: "6.25rem",
        165: "10.313rem",
        220: "13.75rem",
        359: "22.438rem",
      },
      padding: {
        180: "11.25rem",
      },
      gridTemplateColumns: {
        "community-main": "14.75rem 82.2%",
      },
      gridTemplateRows: {
        "community-main": "100%",
      },
      fontFamily: {
        pretendard: "Pretendard",
      },
      fontSize: {
        12: "0.75rem",
        18: "1.125rem",
        16: "1rem",
      },
      lineHeight: {
        14: "0.875rem",
        19: "1.188rem",
        21: "1.313rem",
      },
      colors: {
        "text-color": "#222222",
        "border-color": "#DDDDDD",
        "number-grey": "#999999",
        "number-real-grey": "F8F8F8",
      },
      borderRadius: {
        40: "2.5rem",
      },
    },
  },
  plugins: [],
};
