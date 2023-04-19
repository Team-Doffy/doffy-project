import Image from "next/image";
//import footerLogo from "/image/footer_logo.svg";

function Footer() {
  return (
    <footer className="bg-black text-center text-white">
      <div className="p-10">
        <div className="grid gap-40 lg:grid-cols-2">
          <div className="mb-6 md:mb-0 text-start">
            <div className="mb-5">
              <Image src="/images/footer_logo.svg" alt="footer-img" width={137} height={41}/>
            </div>
            <p className="mb-4">
              Copyright ⓒ2023 all rights reserved
            </p>
          </div>

          <div className="mb-6 md:mb-0 flex flex-col justify-end">
            <ul className="mb-5 flex flex-row space-x-4 justify-end">
              <li>이용약관</li>
              <li className="before:content-['|']"></li>
              <li>개인정보처리방침</li>
            </ul>
            <p className="mb-4 underline text-end">
              Get In Touch With Us
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
