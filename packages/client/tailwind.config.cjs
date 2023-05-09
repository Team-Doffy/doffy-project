/** @type {import('tailwindcss').Config} */

const colors = {
  skyblue: "#057FEF",
  deepblue: "#003192",
  aliceblue: "#F0F8FF",
  whitesmoke: "#FAFDFF",
  mintgreen: "#08E8C2",
  burntorange: "#F4440C",
  charcoal: "#222222",
  grayish: "#666666",
  lightgray: "#999999",
  softgray: "#DDDDDD",
  offwhite: "#F4F4F4",
  snow: "#F8F8F8",
  midnight: "#00102F",
  navyblue: "#0A1D44",
  slateblue: "#1F3562",
  royalblue: "#324F8D",
  paleblue: "#A8BBD4",
  coolgray: "#C8CFDA"
};

module.exports = {
  content: ["./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors,
      width: {
        27: "1.688rem",
        120: "7.5rem",
        352: "22rem"
      },
      height: {
        18: "1.125rem",
        42: "2.625rem",
        100: "6.25rem",
        165: "10.313rem",
        220: "13.75rem",
        359: "22.438rem"
      },
      padding: {
        180: "11.25rem"
      },
      gridTemplateColumns: {
        "community-main": "14.75rem 82.2%"
      },
      gridTemplateRows: {
        "community-main": "100%",
        "content-area": "minmax(0, 13.563rem)"
      },
      fontFamily: {
        pretendard: "Pretendard"
      },
      fontSize: {
        12: "0.75rem",
        13: "0.813rem",
        18: "1.125rem",
        15: "0.938rem",
        16: "1rem"
      },
      lineHeight: {
        14: "0.875rem",
        16: "1rem",
        18: "1.125rem",
        19: "1.188rem",
        21: "1.313rem"
      },
      borderRadius: {
        40: "2.5rem"
      },
      margin: {
        "-10": "-0.625rem"
      }
    }
  },
  plugins: []
};
