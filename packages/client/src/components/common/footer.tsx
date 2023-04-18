import Image from "next/image";
// import footerLogo from "/image/footer_logo.svg";

function Footer() {
  return (
    <footer className="bg-black text-center text-white">
      <div className="grid gap-4 lg:grid-cols-2">
        <div>Doffy Logo</div>
        {/* <Image src={footerLogo} alt="footer-img"></Image> */}
        <div>Copyright ⓒ2023 all rights reserved</div>
      </div>
      <div>
        <ul>
          <li>이용약관</li>
          <li>개인정보처리방침</li>
        </ul>
      </div>
      <div>Get In Touch With Us</div>
    </footer>
  );
}

export default Footer;
