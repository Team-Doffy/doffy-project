import DocsCardView from "../common/DocsCardView";

interface DocsListProps {
  docsList: {
    id: number;
    title: string;
  }[];
}

const DocsList: React.FC<DocsListProps> = ({ docsList }) => {
  return (
    <>
      {docsList.map((docs) => {
        return <DocsCardView key={docs.id} docs={docs} width="w-280" />;
      })}
    </>
  );
};

export default DocsList;
